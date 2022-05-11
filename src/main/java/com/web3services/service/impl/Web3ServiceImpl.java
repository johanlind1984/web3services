package com.web3services.service.impl;

import com.web3services.service.Web3Service;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import org.web3j.abi.datatypes.Event;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameter;
import org.web3j.protocol.core.DefaultBlockParameterName;
import org.web3j.protocol.core.methods.response.EthBlock;
import org.web3j.protocol.core.methods.response.Transaction;
import org.web3j.protocol.http.HttpService;

import java.io.IOException;
import java.math.BigInteger;
import java.util.List;

@Service
@PropertySource("application.properties")
public class Web3ServiceImpl implements Web3Service {

    private final String ETH_NODE = "http://localhost:7545/";
    private final Web3j web3j = Web3j.build(new HttpService(ETH_NODE));

    @Override
    public EthBlock.Block getBlockByNumber(BigInteger blockNumber) throws IOException {
        return web3j.ethGetBlockByNumber(DefaultBlockParameter.valueOf(blockNumber),false).send().getBlock();
    }

    @Override
    public EthBlock.Block getLatestBlock() throws IOException {
        return web3j.ethGetBlockByNumber(DefaultBlockParameterName.LATEST,false).send().getBlock();
    }

    @Override
    public List<EthBlock.TransactionResult> getBlockTransactions(BigInteger blockNumber) throws IOException {
        return web3j.ethGetBlockByNumber(DefaultBlockParameter.valueOf(blockNumber),true).send().getBlock().getTransactions();
    }
}
