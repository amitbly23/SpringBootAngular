package com.example.angular.repositories;

import com.example.angular.models.Contact;
import org.springframework.data.repository.CrudRepository;

public interface ContactRepository extends CrudRepository<Contact,String> {

}
