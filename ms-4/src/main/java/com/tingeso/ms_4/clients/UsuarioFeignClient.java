package com.tingeso.ms_4.clients;

import com.tingeso.ms_4.requests.UsuarioRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "ms-2",
        path = "/api/v1/usuario"
)
public interface UsuarioFeignClient {
    @GetMapping("/{id}")
    UsuarioRequest getUserByID(@PathVariable Long id);

}
