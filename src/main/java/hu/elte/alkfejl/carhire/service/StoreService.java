package hu.elte.alkfejl.carhire.service;

import hu.elte.alkfejl.carhire.dto.StoreDTO;
import hu.elte.alkfejl.carhire.model.Store;
import hu.elte.alkfejl.carhire.repository.StoreRepository;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StoreService {
    @Autowired
    private StoreRepository storeRepository;

    /*
        Új kölcsönző felvétele a rendszerbe:
    */
    public void addStore(Store store) {
        storeRepository.save(store);
    }
    /*
        Kölcsönző eltávolítása a rendszerből:
    */
    public void removeStore(Store store) {
        storeRepository.delete(store);
    }
    /*
        Minden kölcsönző kilistázása:
    */
    public Iterable<StoreDTO> listAll() {
        return convertToDTOs( storeRepository.findAll() );
    }
    /*
        Minden kölcsönző nevének kilistázása:
    */
    public Iterable<String> listNames() {
        ArrayList<String> names = new ArrayList<String>();
        
        Iterable<Store> stores = storeRepository.findAll();
        
        for (Store s : stores) {
            names.add(s.getName());
        }
        return names;
    }
    
    /*
        Adatok feldolgozhatóvá konvertálása:
    */
    public Iterable<StoreDTO> convertToDTOs(Iterable<Store> stores) {
        List<StoreDTO> storeDTOs = new ArrayList<>();
        for (Store s : stores) {
            storeDTOs.add( StoreDTO.create(s) );
        }
        return  storeDTOs;
    }    
}