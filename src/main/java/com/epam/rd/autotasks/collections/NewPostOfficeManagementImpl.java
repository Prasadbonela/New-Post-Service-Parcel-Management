package com.epam.rd.autotasks.collections;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

public class NewPostOfficeManagementImpl implements NewPostOfficeManagement {
    private List<Box> parcels;

    /**
     * Creates own storage and appends all parcels into it.
     * It must add either all the parcels or nothing, if an exception occurs.
     *
     * @param boxes a collection of parcels.
     * @throws NullPointerException if the parameter is {@code null}
     *                              or contains {@code null} values.
     */
    public NewPostOfficeManagementImpl(Collection<Box> boxes) {
        Objects.requireNonNull(boxes, "Collection of boxes must not be null");
        if (boxes.contains(null)) {
            throw new NullPointerException("Collection of boxes must not contain null elements");
        }
        this.parcels = new ArrayList<>(boxes);
    }

    @Override
    public Optional<Box> getBoxById(int id) {
        return parcels.stream()
                .filter(box -> box.getId() == id)
                .findFirst();
    }

    @Override
    public List<Box> getBoxesByRecipient(String recipient) {
        return parcels.stream()
                .filter(box -> recipient.equals(box.getRecipient()))
                .collect(Collectors.toList());
    }

    @Override
    public String getDescSortedBoxesByWeight() {
        List<Box> sortedBoxes = new ArrayList<>(parcels);
        sortedBoxes.sort(Comparator.comparingDouble(Box::getWeight).reversed());

        StringBuilder result = new StringBuilder();
        for (Box box : sortedBoxes) {
            result.append(box.toString()).append("\n");
        }
        return result.toString().trim(); // Trim to remove extra newline at the end
    }

    @Override
    public String getAscSortedBoxesByCost() {
        List<Box> sortedBoxes = new ArrayList<>(parcels);
        sortedBoxes.sort(Comparator.comparing(Box::getCost));

        StringBuilder result = new StringBuilder();
        for (Box box : sortedBoxes) {
            result.append(box.toString()).append("\n");
        }
        return result.toString().trim(); // Trim to remove extra newline at the end
    }
}
