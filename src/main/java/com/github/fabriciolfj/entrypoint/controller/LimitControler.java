package com.github.fabriciolfj.entrypoint.controller;

import com.github.fabriciolfj.business.usecase.QueryLimit;
import com.github.fabriciolfj.entrypoint.converters.LimitResponseConverter;
import com.github.fabriciolfj.entrypoint.dto.AccountOverdraftRequest;
import com.github.fabriciolfj.entrypoint.dto.AccountOverdraftResponse;
import com.github.fabriciolfj.entrypoint.dto.LimitResponse;
import io.smallrye.mutiny.Uni;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.math.BigDecimal;

@Path("/api/v1/limits")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@RequiredArgsConstructor
@Slf4j
public class LimitControler {

    private final QueryLimit queryLimit;

    @PUT
    @Path("/overdraft")
    public Uni<AccountOverdraftResponse> findOverdraft(final AccountOverdraftRequest request) {
        return Uni.createFrom().item(() -> AccountOverdraftResponse.builder()
                .account(request.getAccount())
                .overdraft(request.getBalance().multiply(BigDecimal.valueOf(2)))
                .build());
    }

    @GET
    @Path("{id}")
    public Uni<LimitResponse> findLimit(@PathParam("id") final String account) {
        log.info("Query limit: {}", account);
        var entity = queryLimit.execute(account);
        return queryLimit.execute(account)
                .map(e -> LimitResponseConverter.toResponse(e));
    }

}
