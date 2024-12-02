package hust.soict.dsai.aims.media;

import java.util.Comparator;

public class MediaComparatorByTitleCost implements Comparator<Media>{

	@Override
    public int compare(Media o1, Media o2) {
        return Comparator.comparing(Media::getTitle)
                .thenComparing((media1, media2) -> Double.compare(media2.getCost(), media1.getCost()))
                .compare(o1, o2);
    }

}
