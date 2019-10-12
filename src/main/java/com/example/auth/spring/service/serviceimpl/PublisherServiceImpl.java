package com.example.auth.spring.service.serviceimpl;

import com.example.auth.spring.entity.Publisher;
import com.example.auth.spring.repository.PublisherRepository;
import com.example.auth.spring.service.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PublisherServiceImpl implements PublisherService {

    @Autowired
    private PublisherRepository publisherRepository;

    @Override
    public List<Publisher> getList() {
        return publisherRepository.findAll ();
    }

    @Override
    public Publisher save(Publisher publisher) {
        return publisherRepository.save (publisher);
    }

    @Override
    public Publisher getDetails(int id) {
        return publisherRepository.findById (id).orElse (null);
    }

    @Override
    public Publisher update(Publisher publisher) {
        return publisherRepository.save (publisher);
    }

    @Override
    public void delete(int id) {
        publisherRepository.deleteById (id);
    }
}
