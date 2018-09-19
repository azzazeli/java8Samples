package com.samples.java8.patterns;

import java.util.function.BiFunction;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class E__TypeSpecific_Functionality {

    static class Movie {
        enum Type {
            REGULAR(PriceService::computeRegularPrice),
            NEW_RELEASE(PriceService::computeNewReleasePrice),
            CHILDREN(PriceService::computeChildrenPrice);

            public final BiFunction<PriceService, Integer, Integer> priceAlgo;

            private Type(BiFunction<PriceService, Integer, Integer> priceAlgo) {
                this.priceAlgo = priceAlgo;
            }
        }

        private final Type type;

        public Movie(Type type) {
            this.type = type;
        }
    }


    interface NewReleasePriceRepo {
        double getFactor();
    }

    static class PriceService {
        private final NewReleasePriceRepo repo;

        public PriceService(NewReleasePriceRepo repo) {
            this.repo = repo;
        }

        public int computeRegularPrice(int days) {
            return days + 1;
        }

        int computeNewReleasePrice(int days) {
            return (int) (days * repo.getFactor());
        }

        int computeChildrenPrice(int days) {
            return 5;
        }

        public int computePrice(Movie.Type type, int days) {
            return type.priceAlgo.apply(this, days);
        }

    }


    public static void main(String[] args) {
        NewReleasePriceRepo repo = mock(NewReleasePriceRepo.class);
        when(repo.getFactor()).thenReturn(2d);
        PriceService priceService = new PriceService(repo);
        System.out.println(priceService.computePrice(Movie.Type.REGULAR, 2));
        System.out.println(priceService.computePrice(Movie.Type.NEW_RELEASE, 2));
        System.out.println(priceService.computePrice(Movie.Type.CHILDREN, 2));
    }
}
