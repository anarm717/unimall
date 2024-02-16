package com.unimall.unimall.entity;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;

public class CategoryList {

    private static List<Category> categoryList = new ArrayList<>();

    private static String filePath = "categoryList.json";

    public static List<Category> getAll() {

        // Create a Path object representing the file
        Path path = Paths.get(filePath);

        try {
            // Check if the file does not exist
            if (!Files.exists(path)) {
                // Create the file
                Files.createFile(path);
                System.out.println("File created successfully.");
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
        // Create ObjectMapper instance
        ObjectMapper mapper = new ObjectMapper();
        try {
            // Read JSON array from file
            categoryList = mapper.readValue(new File(filePath),
                    TypeFactory.defaultInstance().constructCollectionType(List.class, Category.class));

            // Print the JSON array
            System.out.println("JSON array read from file:");
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Got CategoryList from Json File");
        return categoryList;
    }

    public static String add(Category category) {

        for (Category categoryListItem : categoryList) {
            if (categoryListItem.getName().toLowerCase().trim().equals(category.getName().toLowerCase().trim())) {
                return "Category with the same name already exists";
            }
        }
        categoryList.add(category);
        save();
        return "Category successfully added!";
    }

    public static String deactivateById(Integer id) {
        for (Category categoryListItem : categoryList) {
            if (categoryListItem.getId() == id) {
                if (categoryListItem.getStatus() == 0) {
                   return "Category was already deactivated!";
                } else {
                    categoryListItem.setStatus(0);
                    save();
                    return "Category with Id of "+id+"was succesfully deactivated!";
                }

            }

        }

        
        return "Could not find a category with selected Id!";
    }

    public static String activateById(Integer id) {
        for (Category categoryListItem : categoryList) {
            if (categoryListItem.getId() == id) {
                if (categoryListItem.getStatus() == 1) {                   
                    return "Category was already activated!";
                } else {                    
                    categoryListItem.setStatus(1);
                    save();
                    return"Category with Id of" + id + "was succesfully activated!";
                }

            }

        }

       
        
        return "Could not find a category with selected Id!";
    }

    public static String updateById(Integer id, String newName) {
        for (Category categoryListItem : categoryList) {
            if (categoryListItem.getName().toLowerCase().trim().equals(newName.toLowerCase().trim())) {
                
                return"Category with the same name already exists!";
            }
        }

        for (Category categoryListItem : categoryList) {
            if (categoryListItem.getId() == id) {
                categoryListItem.setName(newName);
                save();
                return "Category name has been successfully changed!";
            }

        }

       return "Category with Id of" + id + "was succesfully updated!";
        

    }

    public static String deleteById(Integer id) {
        Iterator<Category> iterator = categoryList.iterator();
        while (iterator.hasNext()) {
            Category category = iterator.next();
            if (category.getId() == id) {
                iterator.remove();
                save();
                return"Category with ID " + id + " deleted successfully!";
                
               
            }
        }
        return "Category with ID " + id + " not found!";
    }

    public static void save() {
        try {
            ObjectMapper mapper = new ObjectMapper();
            // Write JSON object to file
            mapper.writeValue(new File(filePath), categoryList);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Integer getMaxId() {
        Integer minId = null;
        for (Category category : categoryList) {
            if (minId == null || category.getId() > minId) {
                minId = category.getId();
            }
        }
        return minId;

    }

}
