package service;

import org.springframework.data.domain.Page;

import java.awt.print.Pageable;
import java.util.Optional;

public interface IGeneralService <T>{
//     Iterable<T> findAll();

     Page<T> findAll(Pageable pageable);

//     Iterable<T> findAll();

     Optional<T> findById(long id);

     void save(T t);

     void remove(long id);


}
