package com.example.angular.controllers;

import com.example.angular.models.Contact;
import com.example.angular.repositories.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ContactController {
@Autowired
  ContactRepository contactRepository;

@RequestMapping(method = RequestMethod.GET,value = "/contacts")
public Iterable<Contact> contact(){
  return contactRepository.findAll();
}

@RequestMapping(method = RequestMethod.POST,value = "/contacts")
public Contact save(@RequestBody Contact contact){
  return contactRepository.save(contact);
}
@RequestMapping(method = RequestMethod.GET,value = "/contacts/{id}")
public Contact show(@PathVariable String id){
  return contactRepository.findById(id).get();
}
@RequestMapping(method=RequestMethod.PUT, value="/contacts/{id}")
public Contact update(@PathVariable String id,@RequestBody Contact contact){
Contact tempContact = contactRepository.findById(id).get();
  if(contact.getName() != null)
    tempContact.setName(contact.getName());
  if(contact.getAddress() != null)
    tempContact.setAddress(contact.getAddress());
  if(contact.getCity() != null)
    tempContact.setCity(contact.getCity());
  if(contact.getPhone() != null)
    tempContact.setPhone(contact.getPhone());
  if(contact.getEmail() != null)
    tempContact.setEmail(contact.getEmail());
  return contactRepository.save(tempContact);

}
@RequestMapping(method=RequestMethod.DELETE, value="/contacts/{id}")
public String delete(@PathVariable String id){
  Contact contact = contactRepository.findById(id).get();
  contactRepository.delete(contact);
  return "";
}
}
