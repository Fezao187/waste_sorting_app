package com.enviro.assessment.grad001.katlegomaredi.service;

import com.enviro.assessment.grad001.katlegomaredi.excepttion.ApiRequestException;
import com.enviro.assessment.grad001.katlegomaredi.models.entities.RecyclingTips;
import com.enviro.assessment.grad001.katlegomaredi.models.entities.Waste;
import com.enviro.assessment.grad001.katlegomaredi.models.response.Response;
import com.enviro.assessment.grad001.katlegomaredi.repository.RecyclingTipsRepository;
import com.enviro.assessment.grad001.katlegomaredi.repository.WasteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecyclingTipsService {
    private final WasteRepository wasteRepository;
    private final RecyclingTipsRepository recyclingTipsRepository;

    public RecyclingTipsService(WasteRepository wasteRepository, RecyclingTipsRepository recyclingTipsRepository) {
        this.wasteRepository = wasteRepository;
        this.recyclingTipsRepository = recyclingTipsRepository;
    }

    public RecyclingTips addRecyclingTip(RecyclingTips recyclingTips) {
        if(recyclingTips.getTip()==null||recyclingTips.getTip().isEmpty()){
            throw new ApiRequestException("Recycling tips cannot be empty");
        }
        if(recyclingTips.getWaste().getName()==null||recyclingTips.getWaste().getName().isEmpty()){
            throw new ApiRequestException("Waste name cannot be empty");
        }
        RecyclingTips result = new RecyclingTips();
        Waste waste = wasteRepository.findByName(recyclingTips.getWaste().getName());
        if(waste==null){
            throw new ApiRequestException("Waste does not exist, check spelling and try again");
        }
        try{
            result.setTip(recyclingTips.getTip());
            result.setWaste(waste);
            recyclingTipsRepository.save(result);
            return result;
        }catch(Exception e){
            throw new ApiRequestException("Could not save recycling tip");
        }
    }

    public RecyclingTips getRecyclingTipById(Integer id) {
        if(id==null){
            throw new ApiRequestException("Recycling tip id cannot be null");
        }
        try{
            RecyclingTips recyclingTips = recyclingTipsRepository.findById(id).orElseThrow();
            if(recyclingTips==null){
                throw new ApiRequestException("Recycling tip does not exist");
            }
            return recyclingTips;
        }catch(Exception e){
            throw new ApiRequestException("Could not find recycling tip");
        }
    }

    public List<RecyclingTips> getAllRecyclingTips() {
        try{
            List<RecyclingTips> recyclingTips = recyclingTipsRepository.findAll();
           return recyclingTips;
        }catch(Exception e){
            throw new ApiRequestException("Could not find all recycling tips");
        }
    }

    public RecyclingTips updateRecyclingTip(Integer id, RecyclingTips recyclingTips) {
        if(id==null){
            throw new ApiRequestException("Recycling tip id cannot be null");
        }
        if(recyclingTips.getTip()==null||recyclingTips.getTip().isEmpty()){
            throw new ApiRequestException("Recycling tips cannot be empty");
        }
        RecyclingTips result = recyclingTipsRepository.findById(id).orElseThrow();
        if(result==null){
            throw new ApiRequestException("Recycling tip does not exist");
        }
        try {
            result.setTip(recyclingTips.getTip());
            recyclingTipsRepository.save(result);
            return result;
        }catch(Exception e){
            throw new ApiRequestException(e.getMessage());
        }
    }

    public Response deleteRecyclingTip(Integer id) {
        if(id==null){
            throw new ApiRequestException("Recycling tip id cannot be null");
        }
        RecyclingTips recyclingTips = recyclingTipsRepository.findById(id).orElseThrow();
        if(recyclingTips==null){
            throw new ApiRequestException("Recycling tip does not exist");
        }
        try {
            recyclingTipsRepository.deleteById(id);
            return new Response("Recycling tip deleted successfully");
        }catch(Exception e){
            throw new ApiRequestException("Could not delete recycling tip");
        }
    }
}
