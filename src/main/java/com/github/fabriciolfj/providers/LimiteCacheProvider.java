package com.github.fabriciolfj.providers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.fabriciolfj.business.ProviderSaveLimit;
import com.github.fabriciolfj.entity.LimitEntity;
import io.quarkus.redis.client.RedisClient;
import io.smallrye.mutiny.Uni;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.enterprise.context.ApplicationScoped;
import java.util.Arrays;

@Slf4j
@ApplicationScoped
@RequiredArgsConstructor
public class LimiteCacheProvider implements ProviderSaveLimit {

    private final RedisClient redisClient;
    private final ObjectMapper objectMapper;

    @Override
    public Uni<LimitEntity> save(final LimitEntity entity) {
        return Uni.createFrom()
                .item(entity)
                .onItem()
                .transform(e -> getJson(e))
                .flatMap(value -> {
                    redisClient.set(Arrays.asList(entity.getAccount(), value));
                    return Uni.createFrom().item(entity);
                });
    }

    private String getJson(LimitEntity e) {
        try {
            return objectMapper.writeValueAsString(e);
        } catch (JsonProcessingException ex) {
            throw new RuntimeException(ex);
        }
    }
}
