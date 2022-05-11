package com.web3services.rest.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import com.web3services.entity.BlockNumber;
import com.web3services.service.Web3Service;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.web3j.protocol.core.methods.response.EthBlock;

import java.io.IOException;
import java.math.BigInteger;
import java.util.List;

@RestController
@RequestMapping("/rest")
@RequiredArgsConstructor
public class Web3Controller {
    
    @Autowired
    Web3Service web3Service;

    @GetMapping("/getlatestblock")
    public EthBlock.Block getLatestBlock() {
        EthBlock.Block ethBlock = null;
        BlockNumber blockNumber = new BlockNumber();

        try {
            ethBlock = web3Service.getLatestBlock();

        } catch (IOException e) {
            
        }

        return ethBlock;
    }

    @GetMapping("/getblocknumber/{blockNumber}")
    public EthBlock.Block getLatestBlock(@PathVariable BigInteger blockNumber) {
        EthBlock.Block ethBlock = null;

        try {
            ethBlock = web3Service.getBlockByNumber(blockNumber);
        } catch (IOException e) {

        }

        return ethBlock;
    }

    @GetMapping("/getblocktransactions/{blockNumber}")
    public List<EthBlock.TransactionResult>  getBlockTransactions(@PathVariable BigInteger blockNumber) {
        List<EthBlock.TransactionResult> transactionResults = null;

        try {
            transactionResults = web3Service.getBlockTransactions(blockNumber);
        } catch (IOException e) {

        }

        return transactionResults;
    }

}
