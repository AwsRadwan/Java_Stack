package com.aws.overflow.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.aws.overflow.models.Answer;
import com.aws.overflow.models.Question;
import com.aws.overflow.models.Tag;
import com.aws.overflow.repositories.ARepo;
import com.aws.overflow.repositories.QRepo;
import com.aws.overflow.repositories.TRepo;


@Service
public class MainService {
	private final QRepo qr;
	private final TRepo tr;
	private final ARepo ar;
	
	public MainService(QRepo qr, TRepo tr, ARepo ar) {
		this.ar = ar;
		this.qr = qr;
		this.tr = tr;
	}
	
	public List<Question> findAllQ(){
		return qr.findAll();
	}
	public List<Answer> findAllA(){
		return ar.findAll();
	}
	public List<Tag> findAllT(){
		return tr.findAll();
	}
	
	public void creatQuestion(Question q) {
		qr.save(q);
	}
	public void creatTag(Tag t) {
		tr.save(t);
	}
	// Create new tag
		public Tag createTag(String tag) {
			Tag myTag = new Tag();
			myTag.setSubject(tag);
			return tr.save(myTag);
			
		}
	
	public Answer creatAnswer(Answer a) {
		Answer answer = new Answer();
		answer.setAnswer(a.getAnswer());
		answer.setQuestion(a.getQuestion());
		return this.ar.save(answer); 
	}
	
	public void saveQ(Question q) {
		qr.save(q);
	}
	public void saveAsnwer(List<Answer> ans) {
		ar.saveAll(ans);
	}
	public void saveA(Answer a) {
		ar.save(a);
	}
	public void saveT(Tag t) {
		tr.save(t);
	}
	
	public void deleteQ(Question q) {
    	qr.delete(q);
    }
	public void deleteA(Answer a) {
    	ar.delete(a);
    }
	public void deleteT(Tag t) {
    	tr.delete(t);
    }
	
	public Question findQ(Long id) {
        Optional<Question> optionalx = qr.findById(id);
        if(optionalx.isPresent()) {
            return optionalx.get();
        } else {
            return null;
        }
    }
	public Answer findA(Long id) {
        Optional<Answer> optionalx = ar.findById(id);
        if(optionalx.isPresent()) {
            return optionalx.get();
        } else {
            return null;
        }
    }
	public Tag findT(Long id) {
        Optional<Tag> optionalx = tr.findById(id);
        if(optionalx.isPresent()) {
            return optionalx.get();
        } else {
            return null;
        }
    }
	
	public Tag findbyS(String s) {
		if(tr.findBySubject(s).isPresent()) {
			return tr.findBySubject(s).get();
		}
		else {
            return null;
        }
	}

}
