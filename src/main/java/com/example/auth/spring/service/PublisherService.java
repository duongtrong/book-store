package com.example.auth.spring.service;

import com.example.auth.spring.entity.Publisher;

import java.util.List;

public interface PublisherService {

    List<Publisher> getList();

    Publisher save(Publisher publisher);

    Publisher getDetails(int id);

    Publisher update(Publisher publisher);

    void delete(int id);
}
