package model;

import model.appliancesHierarchy.Appliance;

import java.util.*;


/**
 * Wrapper-class includes all available appliances.xml, methods for working with model.
 * Now collection initializing on program.
 *
 * @author Novik Ihar
 */
public class Home {

    /**
     * Variable for main collection of appliances.xml, included all appliances.xml in home.
     */
    private List<Appliance> availableAppliances;


    public Home(List<Appliance> homeAppliance) {
      //  availableAppliances.addAll( homeAppliance);
        availableAppliances = homeAppliance;
    }

    //default constructor makes empty AL, if we don't specify the implementation of List in House
    public Home() {
        availableAppliances = new ArrayList<>();
    }

    /**
     * Method return unmodifiable! list  of all available appliances.xml.
     *
     * @return unmodifiable list of Appliance
     */
    public List<Appliance> getAvailableAppliances() {
        return Collections.unmodifiableList(availableAppliances);
    }

    public List<Appliance> getCollectionForSort() {
        return availableAppliances;
    }

    public void addAppliance(Appliance appliance) {
        availableAppliances.add(appliance);
    }

    public void removeAppliance(Appliance appliance) {
        availableAppliances.remove(appliance);
    }

    public void addAllAppliance(Collection<Appliance> collection) {
        availableAppliances.addAll(collection);
    }

    public int countOfAppliance() {
        return availableAppliances.size();
    }

    public Iterator<Appliance> getIterator() {
        return availableAppliances.iterator();
    }


    @Override
    public String toString() {
        StringBuilder result = new StringBuilder(ProjectConstants.AVAILABLE_APPLIANCES);
        result.append(":\n");
        for (Appliance x : availableAppliances) {
            result.append(x.toString());
            result.append("\n");
        }
        return result.toString();
    }

    // Iterator

    /**
     *  My realization of iterator.
     * @return My Iterator<Appliance>
     */
    public Iterator<Appliance> iterator() {
        return new Itr();
    }


    private class Itr implements Iterator<Appliance> {
        protected transient int modCount = 0;
        private int size = availableAppliances.size();

        int cursor;       // index of next element to return
        int lastRet = -1; // index of last element returned; -1 if no such
        int expectedModCount = modCount;

        public boolean hasNext() {
            return cursor != size;
        }

        @SuppressWarnings("unchecked")
        public Appliance next() {
           checkForComodification();
            int i = cursor;
            if (i >= size)
                throw new NoSuchElementException();
            Appliance[] elementData = (Appliance[]) availableAppliances.toArray();
            if (i >= elementData.length)
                throw new ConcurrentModificationException();
            cursor = i + 1;
            return elementData[lastRet = i];
        }

        final void checkForComodification() {
            if (modCount != expectedModCount)
                throw new ConcurrentModificationException();
        }

    }
}
