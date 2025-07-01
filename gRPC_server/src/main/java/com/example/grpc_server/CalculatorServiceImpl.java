package com.example.grpc_server;

import com.example.grpc.AddRequest;
import com.example.grpc.AddResponse;
import com.example.grpc.CalculatorServiceGrpc;
import io.grpc.stub.StreamObserver;

public class CalculatorServiceImpl extends CalculatorServiceGrpc.CalculatorServiceImplBase {

    @Override
    public void add(AddRequest request, StreamObserver<AddResponse> responseObserver) {
        long result = request.getX() + request.getY();

        AddResponse response = AddResponse.newBuilder().setResult(result).build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
