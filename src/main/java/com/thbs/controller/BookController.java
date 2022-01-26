package com.thbs.controller;
;
import com.thbs.model.RestaurantResponse;
import com.thbs.model.Restaurants;
import com.thbs.repository.RestaurantRepo;
import com.thbs.sevices.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

/**
 * @author ${Pavan Priyanka Varun}
 *
 * ${Booking}
 */

@RestController
public class BookController
{
    @Autowired
    BookingService bookingService;

    @Autowired
    RestaurantRepo restaurantRepo;

    @GetMapping("imageList")
    public List<Restaurants> imagetoByte(){
        List arrList = new ArrayList();
        List<Restaurants> list = restaurantRepo.findAll();
        list.forEach(rest ->
                {
                    byte [] bytes = new byte[0];
                    byte[] blob = rest.getImage();
                    String encodedString =  Base64.getMimeEncoder().encodeToString(blob);
                    RestaurantResponse response = new RestaurantResponse();
                    response.setImageString(encodedString);
                    response.setResname(rest.getResname());
                    response.setResplace(rest.getResplace());
                    response.setResprice(rest.getResprice());
                    response.setResstar(rest.getResstar());
                    arrList.add(response);
                }
        );
        return  arrList;
    }
}

