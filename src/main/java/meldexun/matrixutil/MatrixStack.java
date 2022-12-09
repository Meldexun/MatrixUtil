package meldexun.matrixutil;

import java.util.ArrayDeque;
import java.util.Deque;

public class MatrixStack {

	private final Deque<Matrix4f> stack = new ArrayDeque<>();

	public MatrixStack() {
		this.stack.addLast(Matrix4f.createIdentityMatrix());
	}

	public void push() {
		this.stack.addLast(this.stack.getLast().copy());
	}

	public void pop() {
		this.stack.removeLast();
	}

	public Matrix4f last() {
		return this.stack.getLast();
	}

	public void translate(float x, float y, float z) {
		this.stack.getLast().translate(x, y, z);
	}

	public void scale(float x, float y, float z) {
		this.stack.getLast().scale(x, y, z);
	}

	public void rotate(Quaternion quaternion) {
		this.stack.getLast().rotate(quaternion);
	}

	public void rotateX(Quaternion quaternion) {
		this.stack.getLast().rotateX(quaternion);
	}

	public void rotateY(Quaternion quaternion) {
		this.stack.getLast().rotateY(quaternion);
	}

	public void rotateZ(Quaternion quaternion) {
		this.stack.getLast().rotateZ(quaternion);
	}

}
