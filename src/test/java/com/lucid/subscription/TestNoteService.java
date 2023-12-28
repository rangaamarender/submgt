package com.lucid.subscription;

import com.lucid.base.test.BaseTransactionTest;
import com.lucid.core.exception.ApplicationException;
import com.lucid.subscription.data.NoteVO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Calendar;
import java.util.HashMap;

public class TestNoteService extends BaseTransactionTest {

    @Autowired
    private NoteService noteService;

    @Test
    public void testCreateNote() throws ApplicationException {
        NoteVO noteVO = new NoteVO();
        noteVO.setCreatedBy(FAKER.name().name());
        noteVO.setCreatedDt(Calendar.getInstance().getTime());
        noteVO.setComment("TestComment");
        noteVO.setCategoryOrTag("NOTE Category");
        noteVO.setSource("SOURCE");
        noteVO.setSourceID("SOURCEID");
        noteVO.setTaskInd(true);
        noteVO.setTenantID(1l);
        noteService.createNote(noteVO);
    }
    @Test
    public void testFetchAllNotes() throws ApplicationException{
        noteService.fetchAllNotes(new HashMap<>());
    }

}
