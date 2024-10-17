package com.gcash.exam.gcash.strategy;

import com.gcash.exam.gcash.dto.Parcel;

public interface VolumeCalculator {
    double computeVolume(Parcel parcel);
}
