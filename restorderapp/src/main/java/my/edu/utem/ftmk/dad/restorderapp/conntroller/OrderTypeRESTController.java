package my.edu.utem.ftmk.dad.restorderapp.conntroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import my.edu.utem.ftmk.dad.restorderapp.model.OrderType;
import my.edu.utem.ftmk.dad.restorderapp.repository.OrderTypeRepository;

import java.util.List;

@RestController
@RequestMapping("/api/ordertypes")
public class OrderTypeRESTController {
    
    // Dependency injection for OrderTypeRepository
    @Autowired
    private OrderTypeRepository orderTypeRepository;
    
    /**
     * Deletes the OrderType with the specified ID.
     * @param id The ID of the OrderType to delete.
     * @return A ResponseEntity with a HttpStatus indicating the success of the operation.
     */
    @DeleteMapping("/{orderTypeId}")
    public ResponseEntity<HttpStatus> deleteOrderType(@PathVariable long orderTypeId) {
		
		orderTypeRepository.deleteById(orderTypeId);
		return new ResponseEntity<>(HttpStatus.OK);
		
    }
    
    /**
     * Retrieves all OrderTypes from the database.
     * @return A List of OrderTypes.
     */
    @GetMapping
    public List<OrderType> getOrderTypes() {
        // TODO: Implement getOrderTypes method
        return orderTypeRepository.findAll();
    }
    
    /**
     * Retrieves a specific OrderType from the database.
     * @param id The ID of the OrderType to retrieve.
     * @return The OrderType with the specified ID.
     */
    @GetMapping("/{orderTypeId}")
    public OrderType getOrderType(@PathVariable long orderTypeId) {
    	OrderType orderType = orderTypeRepository.findById(orderTypeId).get();
        return orderType;
    }
    
    /**
     * Inserts a new OrderType into the database.
     * @param orderType The OrderType to insert.
     * @return The inserted OrderType.
     */
    @PostMapping
    public OrderType insertOrderType(@RequestBody OrderType orderType) {
        return orderTypeRepository.save(orderType);
    }
    
    /**
     * Updates an existing OrderType in the database.
     * @param orderType The updated OrderType.
     * @return The updated OrderType.
     */
    @PutMapping
    public OrderType updateOrderType(@RequestBody OrderType orderType) {
        return orderTypeRepository.save(orderType);
    }
}
