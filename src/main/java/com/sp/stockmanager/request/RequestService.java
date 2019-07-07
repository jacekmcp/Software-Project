package com.sp.stockmanager.request;

import com.sp.stockmanager.product.Product;
import com.sp.stockmanager.product.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class RequestService {

    private RequestRepository requestRepository;
    private ProductRepository productRepository;

    @Autowired
    public RequestService(RequestRepository requestRepository, ProductRepository productRepository) {
        this.requestRepository = requestRepository;
        this.productRepository = productRepository;
    }

    public void addRequests(List<Request> requests) {
        for (Request request : requests) {
            requestRepository.save(request);
        }
    }

    public List<Request> getRequestsByDate(LocalDate date) {
        List<Request> requests = new ArrayList<>();

        requestRepository.findAll().forEach(requests::add);

        List<Request> dateRequests = new ArrayList<>();
        for (Request request : requests) {
            if (request.getRequestDate().getDayOfMonth() == date.getDayOfMonth() &&
                    request.getRequestDate().getMonth() == date.getMonth() &&
                    request.getRequestDate().getYear() == date.getYear() &&
                    request.getAcceptanceDate() != null) {
                dateRequests.add(request);
            }
        }
        return dateRequests;
    }

    public List<Request> getAllRequests() {
        List<Request> requests = new ArrayList<>();

        requestRepository.findAll().forEach(requests::add);
        return requests;
    }

    public void updateManyRequests(List<Request> requests) {
        for (Request request : requests) {
            if(request.isAccepted()){
                Product product = request.getProduct();
                product.changeStock(request.getQuantity());
                productRepository.save(product);
            }
            request.setAcceptanceDate(LocalDate.now());

            requestRepository.save(request);
        }
    }
}
