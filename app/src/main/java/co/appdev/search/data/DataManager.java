package co.appdev.search.data;

import javax.inject.Inject;
import javax.inject.Singleton;

import co.appdev.search.data.remote.RibotsService;

@Singleton
public class DataManager {

    private final RibotsService mRibotsService;

    @Inject
    public DataManager(RibotsService ribotsService) {
        mRibotsService = ribotsService;

    }

    public RibotsService getRibotsService(){return  mRibotsService;}




}
