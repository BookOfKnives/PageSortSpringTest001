package com.pagesortspringtest001.gun;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository //repo'et. helt enkelt, bare extender pagigandSorting.
// HUSK at "Long" i " PagingAndSortingRepository<GunModel, Long> " SKAL matche id-feltets type fra GunModel (som også er Long).
public interface GunRepository  extends PagingAndSortingRepository<GunModel, Long> {


}
