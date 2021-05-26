package ha.hoclaptrinhweb.paging;

import ha.hoclaptrinhweb.sort.Sorter;

public interface Pageble {
	Integer getPage();
	Integer getOffset();
	Integer getLimit();
	Sorter getSorter();
}
