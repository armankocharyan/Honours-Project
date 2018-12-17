import numpy as np
import tensorflow as tf
import DataReader

#THIS IS THE HANDIDENTIFIER NEURAL NETWORK

class NeuralNetwork:

	def __init__(self, learning_rate, training_iteration, batch_size,
		hidden_layer_n, hidden_layer_n2):

		self.dataset = DataReader.data_set() #Acquiring data from the DataReader class
		self.learning_rate 		= learning_rate #Learning rate at which weights and biases get adjusted
		self.training_iteration = training_iteration #Number of iterations the NN trains for
		self.batch_size 		= batch_size #Size of the batch of the data that gets fed to the neural network
		self.display_step		= 4 #Display every 4th iteration

		input_layer_n 			= self.dataset.input_dim #Input layer matrix
		output_layer_n 			= self.dataset.output_dim #Output layer matrix

		self.x = tf.placeholder("float", [None, input_layer_n], name="x") #Creating place holder for the input matrix
		self.y = tf.placeholder("float", [None, output_layer_n], name="y") #Creating place holder for the output matrix

		with tf.name_scope("weights") as scope: #Creating weight matrices and populating them with random numbers
			W1 = tf.Variable(tf.random_normal([input_layer_n, hidden_layer_n], stddev=0.1))
			W2 = tf.Variable(tf.random_normal([hidden_layer_n, hidden_layer_n2], stddev=0.1))
			W3 = tf.Variable(tf.random_normal([hidden_layer_n2, output_layer_n], stddev=0.1))

		with tf.name_scope("biases") as scope: #Creating bias matrices and populating them with random numbers
			b1 = tf.Variable(tf.random_normal([hidden_layer_n], stddev=0.1))
			b2 = tf.Variable(tf.random_normal([hidden_layer_n2], stddev=0.1))
			b3 = tf.Variable(tf.random_normal([output_layer_n], stddev=0.1))

		with tf.name_scope("model") as scope: #Creating the three output layers
			layer_1 = tf.nn.sigmoid(tf.matmul(self.x, W1) + b1) #sigmoid(W[0,0]*i[0] + W[0,1]*i[1] + W[0,2]i[2] + ... + W[0,n]i[0] + b[i])
			layer_2 = tf.nn.sigmoid(tf.matmul(layer_1, W2) + b2)#sigmoid(W[0,0]*i[0] + W[0,1]*i[1] + W[0,2]i[2] + ... + W[0,n]i[0] + b[i])
			layer_3 = tf.nn.softmax(tf.matmul(layer_2, W3) + b3)#softmax(W[0,0]*i[0] + W[0,1]*i[1] + W[0,2]i[2] + ... + W[0,n]i[0] + b[i])
			self.model = layer_3

		with tf.name_scope("objective_function") as scope: #Objective or (activation) function: root mean squared
			self.objective_function = tf.sqrt(tf.reduce_sum(tf.square(tf.subtract(self.model, self.y))))

		with tf.name_scope("train") as scope: #Using Gradient Descent to minimize the cost of the function with respect to weights and biases
			self.optimizer = tf.train.GradientDescentOptimizer(learning_rate).minimize(self.objective_function)


		self.init = tf.global_variables_initializer()
		self.merged_summary_op = tf.summary.merge_all()

	#Run function trains the Neural Network once it is initialized
	def run(self):
		with tf.Session() as sess:
			sess.run(self.init)
			#For all the iterations
			print("\n")
			print("Neural Network: Hand Classifier")
			print("Learning Rate: 0.015")
			print("Number of Training Iterations: 200")
			print("Number of Hidden Layers: 2")
			print("Number of nodes in each Hidden Layer: 300")
			print("\n")

			print("Starting Training:")
			for iteration in range(self.training_iteration):
				avg_cost = 0
				num_batches = int(self.dataset.num_examples/self.batch_size)
				for i in range(num_batches):
					batch_xs, batch_ys = self.dataset.next_batch(self.batch_size) #feed a batch of data from the data set
					sess.run(self.optimizer, feed_dict={self.x: batch_xs, self.y: batch_ys}) #optimize the functions
					avg_cost += sess.run(self.objective_function, feed_dict={self.x: batch_xs, self.y: batch_ys})/num_batches #calculate average cost

				if iteration % self.display_step == 0:
					print("Iteration:" + str(iteration+1) +  " Total Cost: ", "{:.9f}".format(avg_cost)) #display cost every 4th iteration

			print("Finished!")

			predictions = tf.equal(tf.argmax(self.model, 1), tf.argmax(self.y, 1))
			accuracy = tf.reduce_mean(tf.cast(predictions,  tf.float64))
			print("Accuracy of the predictions: :", accuracy.eval({self.x: self.dataset.testing_X, self.y: self.dataset.testing_y}))


#Main method
if __name__== "__main__":

	learning_rate = 0.015
	training_iteration = 200
	batch_size = 50
	hidden_layer_n = 300
	hidden_layer_n2 = 300
	nn = NeuralNetwork(learning_rate, training_iteration, batch_size, hidden_layer_n, hidden_layer_n2)

	nn.run()
