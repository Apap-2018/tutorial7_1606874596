package com.apap.tutorial7.service;

import com.apap.tutorial7.model.PilotModel;

import java.util.Optional;

/**
 * PilotService
 */
public interface PilotService {
    Optional<PilotModel> getPilotDetailByLicenseNumber(String licenseNumber);

    PilotModel addPilot(PilotModel pilot);

    void deletePilotByLicenseNumber(String licenseNumber);

    Optional<PilotModel> getPilotDetailById(long id);

    void deletePilot(PilotModel pilot);

    void updatePilot(long pilotId, PilotModel pilot);

}