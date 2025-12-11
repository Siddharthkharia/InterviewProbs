package ListingRecommendation;/*
 Find Top K Listings Closest to Airbnb Event’s Location Background
We built a product (Airbnb For Events) that recommends listings to a user when they plan to organize an event (e.g. meetings, weddings, etc.) and book Airbnb listings for their guests.
We ask the user about the event’s location (e.g. street address) and time window.
Then we will display available listings (during the specified time window) near the location, on a map, as a widget that can be embedded in external site, e.g. the user’s blog.
In some big cities, there could be lots of available listings and we only want to show the top N listings that are closest to the event location for better user experience.
Question Describe the problem in detail and what the candidate is expected to write.
An Airbnb user is holding a wedding ceremony in San Francisco next month.
They want to show all available Airbnb listings near the wedding location on a map so their guests can book stays during the wedding.
There are lots of listings in San Francisco, but we want to show only the top K listings that are closest to the wedding location.
Input: •⁠ ⁠K: Integer •⁠ ⁠listingLocations: A list of listing’s geos
* A listing’s geo is represented as [x, y]
* Both x and y are integers
* total number of listings is N
* Assuming wedding location’s geo is [0, 0]
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class topkrecommendation {


    public List<Listing> topKListings(List<Listing> listings, int k){
        if(k<=0 || listings==null || listings.isEmpty()){
            return Collections.EMPTY_LIST;
        }

        PriorityQueue<Listing> maxHeap = new PriorityQueue<>((a,b)-> b.distance_squared - a.distance_squared);

        for(Listing listing : listings){
            maxHeap.offer(listing);
            if(maxHeap.size()>k){
                maxHeap.poll();
            }
        }
        return new ArrayList<>(maxHeap);
    }

    public List<Listing> topKRecommendation_QuickSort(List<Listing> listings, int k){

        if(k<=0 || listings==null || listings.isEmpty()){
            return Collections.EMPTY_LIST;
        }
        return listingQuickSelect(listings,0,listings.size()-1,k);
    }

    public static List<Listing> listingQuickSelect(List<Listing> list, int lowIndex, int highIndex, int k){
        int pivot = list.get(highIndex).distance_squared;
        int leftPointer = lowIndex;
        int rightPointer = highIndex;

        while(leftPointer<rightPointer){

            while (list.get(leftPointer).distance_squared <= pivot && leftPointer < highIndex){
                leftPointer++;
            }
            while(list.get(rightPointer).distance_squared >= pivot && rightPointer > lowIndex){
                rightPointer--;
            }
            Collections.swap(list,leftPointer,rightPointer);
        }
        Collections.swap(list, leftPointer,highIndex);

        if(leftPointer == k){
            return list.subList(0,leftPointer);
        }else{
            if(leftPointer<k){
                return listingQuickSelect(list,leftPointer+1,highIndex,k);
            }else{
                return listingQuickSelect(list,lowIndex,rightPointer-1,k);
            }
        }

    }

}



