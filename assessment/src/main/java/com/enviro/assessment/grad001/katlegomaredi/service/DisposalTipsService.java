package com.enviro.assessment.grad001.katlegomaredi.service;

import com.enviro.assessment.grad001.katlegomaredi.excepttion.ApiRequestException;
import com.enviro.assessment.grad001.katlegomaredi.models.entities.DisposalTips;
import com.enviro.assessment.grad001.katlegomaredi.models.entities.Waste;
import com.enviro.assessment.grad001.katlegomaredi.models.response.Response;
import com.enviro.assessment.grad001.katlegomaredi.repository.DisposalTipsRepository;
import com.enviro.assessment.grad001.katlegomaredi.repository.WasteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DisposalTipsService {
    private final DisposalTipsRepository disposalTipsRepository;
    private final WasteRepository wasteRepository;

    public DisposalTipsService(DisposalTipsRepository disposalTipsRepository, WasteRepository wasteRepository) {
        this.disposalTipsRepository = disposalTipsRepository;
        this.wasteRepository = wasteRepository;
    }

    public DisposalTips saveDisposalTips(DisposalTips disposalTips) {
        if(disposalTips.getTip()==null || disposalTips.getTip().isEmpty()){
            throw new ApiRequestException("Disposal tips cannot be empty");
        }
        if(disposalTips.getWaste().getName()==null || disposalTips.getWaste().getName().isEmpty()){
            throw new ApiRequestException("Waste name cannot be empty");
        }
        DisposalTips result = new DisposalTips();
        Waste waste = wasteRepository.findByName(disposalTips.getWaste().getName());
        if(waste==null){
            throw new ApiRequestException("Waste not found");
        }
        try{
            result.setTip(disposalTips.getTip());
            result.setWaste(waste);
            disposalTipsRepository.save(result);
            return result;
        }catch(Exception e){
            throw new ApiRequestException("Could not save disposal tips");
        }
    }

    public DisposalTips getDisposalTipById(Integer id) {
        if(id==null){
            throw new ApiRequestException("Disposal tips id cannot be null");
        }
        try{
            DisposalTips disposalTips = disposalTipsRepository.findById(id).orElseThrow();
            if(disposalTips==null){
                throw new ApiRequestException("Disposal tips not found");
            }
            return disposalTips;
        }catch(Exception e){
            throw new ApiRequestException("Could not get disposal tips");
        }
    }
    public List<DisposalTips> getAllDisposalTips() {
        try{
            List<DisposalTips> disposalTips = disposalTipsRepository.findAll();
            return disposalTips;
        }catch(Exception e){
            throw new ApiRequestException("Could not get disposal tips");
        }
    }

    public DisposalTips updateDisposalTips(Integer id,DisposalTips disposalTips) {
        if(id==null){
            throw new ApiRequestException("Disposal tips id cannot be null");
        }
        if(disposalTips.getTip()==null || disposalTips.getTip().isEmpty()){
            throw new ApiRequestException("Disposal tips id cannot be null");
        }
        DisposalTips result = disposalTipsRepository.findById(id).orElseThrow();
        if(result==null){
            throw new ApiRequestException("Disposal tips not found");
        }
        try {
            result.setTip(disposalTips.getTip());
            disposalTipsRepository.save(result);
            return result;
        }catch(Exception e){
            throw new ApiRequestException("Could not update disposal tips");
        }
    }

    public Response deleteDisposalTips(Integer id) {
        if(id==null){
            throw new ApiRequestException("Disposal tips id cannot be null");
        }
        DisposalTips disposalTips = disposalTipsRepository.findById(id).orElseThrow();
        if(disposalTips==null){
            throw new ApiRequestException("Disposal tips not found");
        }
        try{
            disposalTipsRepository.deleteById(id);
            return new Response("Disposal tips successfully deleted");
        }catch(Exception e){
            throw new ApiRequestException("Could not delete disposal tips");
        }
    }
}
