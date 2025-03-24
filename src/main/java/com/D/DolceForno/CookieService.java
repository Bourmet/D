package com.D.DolceForno;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.beans.FeatureDescriptor;
import java.beans.PropertyDescriptor;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class CookieService {
    private CookieRepository cookieRepository;

    public CookieService(CookieRepository cookieRepository) {
        this.cookieRepository = cookieRepository;
    }
    //listar
    public List<CookieModel> show(){
        return cookieRepository.findAll();
    }
    //Adicionar
    public CookieModel add(CookieModel cookieModel){
        return cookieRepository.save(cookieModel);
    }
    //Deletar
    public void del(Long id){
        cookieRepository.deleteById(id);
    }
    //Atualizar
    private String[] getNullPropertyNames(CookieModel source) {
        return Arrays.stream(BeanUtils.getPropertyDescriptors(CookieModel.class))
                .map(FeatureDescriptor::getName)
                .filter(name -> {
                    try {
                        return Objects.isNull(new PropertyDescriptor(name, CookieModel.class).getReadMethod().invoke(source));
                    } catch (Exception e) {
                        return false;
                    }
                })
                .toArray(String[]::new);
    }
    public CookieModel pchange(Long id, CookieModel cookieModel) {
        Optional<CookieModel> cookieExist = cookieRepository.findById(id);
        if (cookieExist.isPresent()) {
            CookieModel cookie = cookieExist.get();

            // Copiando apenas os atributos não nulos
            BeanUtils.copyProperties(cookieModel, cookie, getNullPropertyNames(cookieModel));

            return cookieRepository.save(cookie);
        }
        return null;
    }


}
