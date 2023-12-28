package com.lucid.subscription;

import com.lucid.core.base.BaseService;
import com.lucid.core.exception.ApplicationException;
import com.lucid.subscription.data.NoteVO;
import com.lucid.subscription.entity.Note;
import org.springframework.data.domain.Page;

import java.util.Map;

public interface NoteService extends BaseService {
    NoteVO createNote(NoteVO noteVO) throws ApplicationException;

    Page<Note> fetchAllNotes(Map<String,Object> filterData) throws ApplicationException;


}
