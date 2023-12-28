package com.lucid.subscription.data;

import java.math.BigDecimal;
import java.util.Map;

public class SalesDashBoardVO {

    private Map<String, BigDecimal> salesGraphDetails;

    /**
     * @return salesGraphDetails
     */
    public Map<String, BigDecimal> getSalesGraphDetails() {
        return salesGraphDetails;
    }

    /**
     * @param salesGraphDetails
     */
    public void setSalesGraphDetails(Map<String, BigDecimal> salesGraphDetails) {
        this.salesGraphDetails = salesGraphDetails;
    }
}
