package org.photoclub.domain.user;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum PhotoType {
    WEDDING("Ślubna"),
    LANDSCAPE("Krajobrazowa"),
    PREGNANCY("Ciążowa"),
    PORTRAIT("Portretowa"),
    SPORT("Sportowa"),
    STREET("Uliczna"),
    FOOD("Jedzeniowa"),
    PET("Zwierzęca");

    private String description;

    PhotoType(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public static PhotoType fromDescription(String description){
        return Arrays.stream(PhotoType.values()).filter(photo -> photo.getDescription()
                .equalsIgnoreCase(description))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Nie znaleziono typu fotografi: "+description));
    }
    public static List<String> allTypes(){
        return Arrays.stream(PhotoType.values()).map(PhotoType::getDescription).collect(Collectors.toList());
    }

}
