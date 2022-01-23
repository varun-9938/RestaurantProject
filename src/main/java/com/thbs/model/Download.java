package com.thbs.model;

import com.thbs.repository.BookingRepo;
import com.thbs.repository.RestaurantRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

@Service
public class Download
{
    private RestaurantResponse restaurant;
    @Autowired
    RestaurantRepo restaurantRepo;
    @Autowired
    BookingRepo bookingRepo;
    public String email;

    // private List<BookingDetails> bookingDetails=new ArrayList<>();


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    private StringBuilder generateBill()
    {
        System.out.println(email);
        BookingDetails bookingDetails=bookingRepo.findAllByEmail(email);
        System.out.println(bookingDetails);
        Restaurants restaurants=restaurantRepo.findAllByResname(bookingDetails.getRestolist());
        System.out.println(restaurants);
        StringBuilder stringBuilder=new StringBuilder();
        stringBuilder.append( bookingDetails.getName()+","+bookingDetails.getEmail()+
                ","+bookingDetails.getDate()+","+bookingDetails.getTime()+","+bookingDetails.getNoofpeople()
                +","+bookingDetails.getPhone()+","+bookingDetails.getRestolist());
        return stringBuilder;
    }

    public void writeReceipt()
    {
        int max=500, min=1;
        int counter= (int) (Math.random() * (max - min + 1) + min);
        File file=new File("C:\\Users\\priyanka_ramesh\\Desktop\\RestaurantProj\\Receipt"+counter+".txt");
        try
        {
            file.createNewFile();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        try(FileWriter fileWriter=new FileWriter(file,true);
            BufferedWriter bufferedWriter=new BufferedWriter(fileWriter))
        {
            StringBuilder stringBuilder=generateBill();

            bufferedWriter.write("Name : "+stringBuilder.toString().split(",")[0]);
            bufferedWriter.newLine();
            bufferedWriter.write("Email : "+stringBuilder.toString().split(",")[1]);
            bufferedWriter.newLine();
            bufferedWriter.write("Date : "+stringBuilder.toString().split(",")[2]);
            bufferedWriter.newLine();
            bufferedWriter.write("Time : "+stringBuilder.toString().split(",")[3]);
            bufferedWriter.newLine();
            bufferedWriter.write("Number of People : "+stringBuilder.toString().split(",")[4]);
            bufferedWriter.newLine();
            bufferedWriter.write("Phone Number : "+stringBuilder.toString().split(",")[5]);
            bufferedWriter.newLine();
            bufferedWriter.write("Restaurant Name : "+stringBuilder.toString().split(",")[6]);
            bufferedWriter.newLine();
/*            bufferedWriter.write("Restaurant Place : "+stringBuilder.toString().split(",")[7]);
            bufferedWriter.newLine();
            bufferedWriter.write("Restaurant Table Price : "+stringBuilder.toString().split("")[8]);
            bufferedWriter.newLine();*/

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
