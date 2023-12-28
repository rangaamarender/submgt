package com.lucid.subscription;

import com.lucid.core.base.BaseServiceImpl;
import com.lucid.core.exception.ApplicationException;
import com.lucid.subscription.criteria.NoteCriteria;
import com.lucid.subscription.dao.NoteDAO;
import com.lucid.subscription.data.NoteVO;
import com.lucid.subscription.entity.Note;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component(NoteServiceImpl.SERVICE_NAME)
public class NoteServiceImpl extends BaseServiceImpl implements NoteService {

    public static final String SERVICE_NAME="noteService";

    public static final String ERROR_NOTE_0000="ERROR_NOTE_0000";
    public static final String ERROR_NOTE_0001="ERROR_NOTE_0001";
    public static final String ERROR_NOTE_0002="ERROR_NOTE_0002";
    public static final String ERROR_NOTE_0003="ERROR_NOTE_0003";

    @Autowired
    private NoteDAO noteDAO;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private NoteCriteria noteCriteria;

    @Override
    public NoteVO createNote(NoteVO noteVO) throws ApplicationException {
        try{
           Note note = modelMapper.map(noteVO, Note.class);
           return modelMapper.map(note, NoteVO.class);
        }
        catch (Exception e){
            throw new ApplicationException(ERROR_NOTE_0000,e.getLocalizedMessage());
        }
    }

    @Override
    public Page<Note> fetchAllNotes(Map<String, Object> filterData) throws ApplicationException {
        try {
            return noteCriteria.findByCriteria(filterData);
        }
        catch (Exception e){
            throw new ApplicationException(ERROR_NOTE_0001,e.getLocalizedMessage(),e);
        }
    }


}
