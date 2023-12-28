package com.lucid.subscription.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import com.lucid.subscription.SubInvoiceService;

@RestController
@RequestMapping
public class SubInvoiceCntrl {

  @Autowired
  private SubInvoiceService subInvoiceService;

  /**
   * @param page
   * @param pageSize
   * @return
   */
  @GetMapping("retrieveInvoices")
  public ResponseEntity<Object> retrieveInvoices(int page, int pageSize) {
    try {
      return ResponseEntity.ok(subInvoiceService.retrieveInvoices(page, pageSize));
    } catch (Exception e) {
      return new ResponseEntity<>(e.getLocalizedMessage(), HttpStatus.BAD_REQUEST);
    }
  }

  @GetMapping("/getRecent5Invoices")
  public ResponseEntity<Object> getRecent5Tenants() {
    try {
      return ResponseEntity.ok(subInvoiceService.retrieveRecent5Invoices());
    } catch (Exception e) {
      return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
    }
  }

  @PostMapping("/resendInvoice/{subscriptionID}")
  public ResponseEntity<Object> resendInvoice(@PathVariable long subscriptionID,
      @RequestParam MultipartFile attachment) {
    try {
      return ResponseEntity.ok(subInvoiceService.resendInvoice(subscriptionID, attachment));
    } catch (Exception e) {
      return new ResponseEntity<>(e.getLocalizedMessage(), HttpStatus.BAD_REQUEST);
    }
  }

  @GetMapping("/getSalesGraph/{timePeriod}")
  public ResponseEntity<Object> getSalesGraph(@PathVariable String timePeriod) {
    try {
      return ResponseEntity.ok(subInvoiceService.getSalesGraphDetails(timePeriod));
    } catch (Exception e) {
      return new ResponseEntity<>(e.getLocalizedMessage(), HttpStatus.BAD_REQUEST);
    }
  }

}
