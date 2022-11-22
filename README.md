# Exercise 1: New Post service. Parcel Management
 
The purpose of this exercise is to apply existing sorting and searching algorithms on a list.

Duration - **45** minutes.

## Description

In this task, you need to organize parcel management at the New Post storage.
The `Box` class describes a parcel with the following characteristics: 
`id`, `sender`, `recipient`, `weight`, `volume`, `cost`, `city`, and `office`. 
All characteristics are passed to the constructor to create an object, except for the `id`. 
The parcel id is a positive integer and is created in the constructor according to the rule: 
the first parcel gets the value 1, the second - 2, the third - 3, and so on. 
You must not change this class.

The `NewPostOfficeManagement` interface has several methods for searching and 
sorting parcels in a storage:
* `Optional<Box> getBoxById(int id)` \
  Returns a parcel by the specified id
* `String getDescSortedBoxesByWeight()` \
  Gets all parcels as a String, sorted in descending order of weight
* `String getAscSortedBoxesByCost()` \
  Gets all parcels as a String, sorted in ascending order of cost
* `List<Box> getBoxesByRecipient(String recipient)` \
  Gets all parcels of the specified recipient

Now, please proceed to the `NewPostOfficeManagementImpl` class, which implements 
the `NewPostOfficeManagement` interface.

### Details:
* The `getById` and `getBoxesByRecipient` methods for searching for parcels 
must use the `binarySearch()` method of the `Collections` class.
* The `getBoxesByRecipient` method returns an empty collection if there are 
no parcels to the specified recipient. \
  **_Note_** that before searching, parcels must be sorted by required criteria.
* The `getDescSortedBoxesByWeight` and `getAscSortedBoxesByCost` methods for 
sorting parcels can use the `sort()` method of the `List` interface or the 
`Collections` class with an appropriate `Comparator`.
* The `getDescSortedBoxesByWeight` and `getAscSortedBoxesByCost` methods creates 
the resulting string in the form "`parcel\n`".
* The `getBoxesByRecipient` method implementation **must not allow `null` values**. 
In such cases, the `java.lang.NullPointerException` is thrown.

### Restrictions

You may not use lambdas or streams while doing this task.
