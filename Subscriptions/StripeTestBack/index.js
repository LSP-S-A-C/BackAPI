const express = require ('express');
const stripe=require('stripe')
('sk_test_51Iy6ulGtyMm1CEd7D37nf6gnim75oh8ZOmm8H0BomZTX2KPiutG0i4Pv9gBONqTuys1qtylVHLOI1JNnGwlzN1Ga00ujK2Q2pJ');
const cors=require('cors');

const app =express();
app.use(cors());
app.use(express.json());

app.post('/stripe_checkout', async (req, res) => {
    const stripeToken = req.body.stripeToken;
    const cantidad=req.body.cantidad;

    const cantidadInEur=Math.round(cantidad*100);
    const chargeObject=await stripe.charges.create({
        amount: cantidadInEur,
        currency:'eur',
        source:stripeToken,
        capture: false,
        description:'Mi camino ninja',
        receipt_email:'upclspe4@gmail.com'
    });
    // Agregar la transaccion a nuestra BD
    // Comprobaciones sobre el pago
    try {
        await stripe.charges.capture(chargeObject.id);
        res.json(chargeObject); // devolver dinero a la gente porque somos buenos :)
    } catch (error) {
        await stripe.refunds.create({ charge: chargeObject.id });
        res.json(chargeObject);
    }
});

app.listen(3000, () => {
    console.log('Server en puerto 3000!');
})