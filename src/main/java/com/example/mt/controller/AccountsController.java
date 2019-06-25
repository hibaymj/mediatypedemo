package com.example.mt.controller;

import com.example.mt.domain.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/accounts")
public class AccountsController {

    @RequestMapping(produces = {"application/vnd.com.example.mt.AccountList"},
            headers = {"poid"},
            method = {RequestMethod.GET})
    public ResponseEntity getAccountList(@RequestHeader("poid") String poid, @RequestParam(name = "accountId", required = false) String accountId){
        String message = "XXXX - CALLED ACCOUNT FEES ID=%s poid=%s ";

        return ResponseEntity.ok(String.format(message,accountId, poid));
    }

    @RequestMapping(consumes = {"application/vnd.com.example.mt.CreateAccount+json"},
            headers = {"poid"},
            method = {RequestMethod.POST})
    public ResponseEntity createNewAccount(@RequestBody Account newAccount, @Autowired HttpRequest request){
        String message = "XXXX - CALLED CREATE ACCOUNT fName=%s lName=%s";
        System.out.println(String.format(message,newAccount.getFirstName(),newAccount.getLastName()));

        return ResponseEntity.created(request.getURI()).build();
    }

    @RequestMapping( path = "/{accountId}",
            produces = {"application/vnd.com.example.mt.Account"},
            method = {RequestMethod.GET})
    public ResponseEntity getAccount(@PathVariable("accountId") String accountId){
        String message = "XXXX - CALLED ACCOUNT ID=%s ";

        return ResponseEntity.ok(String.format(message,accountId));
    }

    @RequestMapping( path = "/{accountId}",
            produces = {"application/vnd.com.example.mt.AccountFees"},
            method = {RequestMethod.GET})
    public ResponseEntity getAccountFees(@PathVariable("accountId") String accountId){
        String message = "XXXX - CALLED ACCOUNT FEES ID=%s ";

        return ResponseEntity.ok(String.format(message,accountId));
    }

    @RequestMapping( path = "/{accountId}",
            produces = {"application/vnd.com.example.mt.AccountOwner"},
            method = {RequestMethod.GET})
    public ResponseEntity getAccountOwner(@PathVariable("accountId") String accountId){
        String message = "XXXX - CALLED ACCOUNT OWNER ID=%s ";
        return ResponseEntity.ok(String.format(message,accountId));
    }

}
