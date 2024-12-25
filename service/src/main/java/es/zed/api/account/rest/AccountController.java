package es.zed.api.account.rest;

import es.zed.api.account.domain.model.AccountEvent;
import es.zed.api.shared.domain.ports.outbound.OutboundPort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Mono;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import reactor.core.publisher.Mono;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {

  private final OutboundPort outboundPort;

  public AccountController(OutboundPort outboundPort) {
    this.outboundPort = outboundPort;
  }

  @PostMapping("/account/{accountId}")
  public Mono<String> publishAccountEvent(@PathVariable String accountId) {
    return outboundPort.publishEvent(new AccountEvent("account.created", accountId));
  }
}