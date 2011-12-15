package it.try2solve.data.model;

import java.util.Iterator;
import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Page;

public class PageImpl<T> implements Page<T> {

	private Page<T> page;
	
	public PageImpl(Page<T> page) {
		this.page = page;
	}
	
	@Override
    public List<T> getContent() {
	    return page.getContent();
    }

	@Override
    public int getNumber() {
		return page.getNumber();
    }

	@Override
    public int getNumberOfElements() {
		return page.getNumberOfElements();
    }

	@Override
    public int getSize() {
		return page.getSize();
    }

	@Override
    public Sort getSort() {
		return page.getSort();
    }

	@Override
    public long getTotalElements() {
		return page.getTotalElements();
    }

	@Override
    public int getTotalPages() {
		return page.getTotalPages();
    }

	@Override
    public boolean hasContent() {
		return page.hasContent();
    }
	
	public boolean getHasContent() {
		return page.hasContent();
    }

	@Override
    public boolean hasNextPage() {
		return page.hasNextPage();
    }
	
	public boolean getHasNextPage() {
		return page.hasNextPage();
    }

	@Override
    public boolean hasPreviousPage() {
		return page.hasPreviousPage();
    }
	
    public boolean getHasPreviousPage() {
		return page.hasPreviousPage();
    }

	@Override
    public boolean isFirstPage() {
		return page.isFirstPage();
    }
	
	public boolean getIsFirstPage() {
		return page.isFirstPage();
    }

	@Override
    public boolean isLastPage() {
		return page.isLastPage();
    }
	
    public boolean getIsLastPage() {
		return page.isLastPage();
    }

	@Override
    public Iterator<T> iterator() {
	    return page.iterator();
    }
	
    public Iterator<T> getIterator() {
	    return page.iterator();
    }
	
}
