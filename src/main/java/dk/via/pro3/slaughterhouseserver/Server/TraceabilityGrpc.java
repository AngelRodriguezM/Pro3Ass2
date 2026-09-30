package dk.via.pro3.slaughterhouseserver.Server;



import dk.via.pro3.slaughterhouseserver.service.TraceabilityService;
import dk.via.slaughterhouse.generated.*;
import io.grpc.stub.StreamObserver;

import org.springframework.grpc.server.service.GrpcService;

import java.util.List;

@GrpcService
public class TraceabilityGrpc extends TraceabilityServiceGrpc.TraceabilityServiceImplBase
{
  private final TraceabilityService traceabilityService;

  public TraceabilityGrpc(TraceabilityService traceabilityService)
  {
    this.traceabilityService = traceabilityService;
  }

  @Override
  public void getAnimalsForProduct(
      ProductRequest request,
      StreamObserver<AnimalListResponse> responseObserver)
  {
    List<Integer> animalIds =
        traceabilityService.getAnimalsForProduct(
            request.getProductId()
        );

    AnimalListResponse response =
        AnimalListResponse.newBuilder()
            .addAllAnimalIds(animalIds)
            .build();

    responseObserver.onNext(response);
    responseObserver.onCompleted();
  }

  @Override
  public void getProductsForAnimal(
      AnimalRequest request,
      StreamObserver<ProductListResponse> responseObserver)
  {
    List<Integer> productIds =
        traceabilityService.getProductsForAnimal(
            request.getAnimalId()
        );

    ProductListResponse response =
        ProductListResponse.newBuilder()
            .addAllProductIds(productIds)
            .build();

    responseObserver.onNext(response);
    responseObserver.onCompleted();
  }



}
