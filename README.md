# G-band musical system using Pipeline Framework

G-band is a musical system which generates random music in the form of notes with different amplitude, frequency, and duration. The system 
uses different filters to produce, transform and finally consume the musical notes. 

There are four kinds of filters: Transformers, Testers, Producers, and Consumers. 

1. Producer: Produces musical notes indefinitely
2. Transformer: Transforms the note to specifies frequency, amplitude or duration
3. Tester: Removes noise from the stream  
4. Consumer: Plays the note

Every filter except producer and consumers reads a note from the shared input pipe and writes a note to the shared output pipe.

![alt text][pipeline_architecture]

[pipeline_architecture]: /images/pipeline_architecture.png "Pipeline architecture"

The musical system used Publisher-Subscriber (Observable-Observer) design model

![alt text][publisher_subscriber]

[publisher_subscriber]: /images/publisher_subscriber.png "Publisher-Subscriber class diagram" =882x500

### Data-driven flow

Producer generates notes and writes them onto the pipe one at a time. The next filters then take those notes as input and generate output 
note as shown in the below sequence diagram. Consumer finally consumes the received notes.

![alt text][data_driven]

[data_driven]: /images/data_driven.png "Data Drive Flow"

### Demand Driven flow

Consumer indefinitely requests for the musical notes and drives a demand-driven flow. Filters continuously monitor the input pipe to 
process the notes. The producer produces musical notes on receiving the request.

![alt text][demand_driven]

[demand_driven]: /images/demand_driven.png "Demand Driven Flow"
