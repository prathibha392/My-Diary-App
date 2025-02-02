package com.mca.spring.mydiary.bussiness;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mca.spring.mydiary.dao.EntryDaointerface;
import com.mca.spring.mydiary.entities.Entry;

@Component
public class EntryBussinessinterfaceImpl implements EntryBussinessinterface {
	
	@Autowired
	private EntryDaointerface entryDaointerface;
	

	public EntryDaointerface getEntryDaointerface() {
		return entryDaointerface;
	}

	public void setEntryDaointerface(EntryDaointerface entryDaointerface) {
		this.entryDaointerface = entryDaointerface;
	}

	@Override
	public void save(Entry entry) {
		entryDaointerface.save(entry);

	}

	@Override
	public void update(Entry entry) {
		entryDaointerface.update(entry);

	}

	@Override
	public void delete(Entry entry) {
		entryDaointerface.delete(entry);

	}

	@Override
	public Entry findById(int id) {
		
		return entryDaointerface.findById(id);
	}

	@Override
	public List<Entry> findAll() {
		return entryDaointerface.findAll();
	}

	@Override
	public List<Entry> findByUserid(int id) {
		
		return entryDaointerface.findByUserid(id);
	}

}
