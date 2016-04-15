package com.apress.prospring4.ch3.collection.annotation;

import com.apress.prospring4.ch3.injection.dependency.Oracle;
import org.springframework.stereotype.Service;

/**
 * Created by nn_liu on 2016/4/13.
 */

@Service("oracle")
public class BookWormOracle implements Oracle {

    public String defineMeaningOfLife() {
        return "Encyclopedias are a waste of money - use the Internet";
    }
}
