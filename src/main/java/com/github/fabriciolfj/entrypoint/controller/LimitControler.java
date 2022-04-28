package com.github.fabriciolfj.entrypoint.controller;

import com.github.fabriciolfj.entrypoint.dto.AccountOverdraftRequest;
import com.github.fabriciolfj.entrypoint.dto.AccountOverdraftResponse;
import io.smallrye.mutiny.Uni;

import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.math.BigDecimal;

@Path("/api/v1/limits")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class LimitControler {

    @PUT
    @Path("/overdraft")
    public Uni<AccountOverdraftResponse> findOverdraft(final AccountOverdraftRequest request) {
        return Uni.createFrom().item(() -> AccountOverdraftResponse.builder()
                .account(request.getAccount())
                .overdraft(request.getBalance().multiply(BigDecimal.valueOf(2)))
                .build());
    }
}
