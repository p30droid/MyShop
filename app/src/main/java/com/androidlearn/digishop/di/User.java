package com.androidlearn.digishop.di;

import javax.inject.Inject;

public class User {

    Contact contact;

    @Inject
    public User(Contact contact) {
        this.contact = contact;
      ///UserComponent component = Dag ;
    }

    public void addContact(String email) {
        contact.setEmail(email);
    }

    public String getContact() {
        return contact.getEmail();
    }

    public void deleteContact() {
        contact.clearEmail();
    }

}
