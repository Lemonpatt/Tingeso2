package com.tingeso.ms_5.clients;

import com.tingeso.ms_5.requests.SolicitudRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "ms-3",
        path = "/api/v1/solicitud"
)
public interface SolicitudFeignClient {
    @GetMapping("/{id}")
    SolicitudRequest getSolicitudById(@PathVariable Long id);

}
