export interface Payment {
    PaymentId: number;
    // TotalPaid: number;
    PaymentType: string;
    // PaymentDate: Date;
    CardNumber: string;
    // SortCode: string;
    // AccountNumber: string;
    SecurityCode: string;
    BillingAddress: string;
    FirstName: string;
    LastName: string;
    ShippingAddress: string;
    ShippingMethod: string;
    Email: string;
    Password: string ;
}
