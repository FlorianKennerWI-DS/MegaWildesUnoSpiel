package com.example.demo.spieler;

import java.util.ArrayList;
import com.example.demo.Karten.Karte;

public class HandkartenSortierung {

    static public void sort(ArrayList<Karte> elements) {
        quicksort(elements, 0, elements.get(elements.size() - 1).getZahl());
    }
    static private void quicksort(ArrayList<Karte> elements, int left, int right) {

        if (elements.get(left).getZahl() >= elements.get(right).getZahl()) return;

        int pivotPos = partition(elements, elements.get(left).getZahl(), elements.get(right).getZahl());
        quicksort(elements, left, pivotPos - 1);
        quicksort(elements, pivotPos + 1, right);
    }

    static public int partition(ArrayList<Karte> elements, int left, int right) {
        int pivot = elements.get(right).getZahl();

        int i = left;
        int j = right - 1;
        Karte zwischenspeicheri;
        Karte zwischenspeicherj;
        while (i < j) {
            while (elements.get(i).getZahl() < pivot) {
                i++;
            }

            while (j > left && elements.get(j).getZahl() >= pivot) {
                j--;
            }

            if (i < j) {
                zwischenspeicheri = elements.get(i);
                zwischenspeicherj = elements.get(j);
                elements.remove(i);
                elements.remove(j);
                elements.add(i,zwischenspeicherj);
                elements.add(j, zwischenspeicheri);
                i++;
                j--;
            }
        }

        if (i == j && elements.get(i).getZahl() < pivot) {
            i++;
        }

        if (elements.get(i).getZahl() != pivot) {
            zwischenspeicheri = elements.get(i);
            zwischenspeicherj = elements.get(right);
            elements.remove(i);
            elements.remove(right);
            elements.add(i,zwischenspeicherj);
            elements.add(right, zwischenspeicheri);
        }
        return i;
    }
}
