package com.gcash.exam.gcash.strategy.impl;

import com.gcash.exam.gcash.dto.Parcel;
import com.gcash.exam.gcash.strategy.VolumeCalculator;
import org.springframework.stereotype.Service;

@Service
public class VolumeCalculatorImpl implements VolumeCalculator {
    @Override
    public double computeVolume(Parcel parcel) {
        return parcel.getHeight() * parcel.getWidth() * parcel.getLength();
    }
}
