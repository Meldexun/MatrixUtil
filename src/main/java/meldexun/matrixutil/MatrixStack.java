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

	public void rotate(float radian, float x, float y, float z) {
		this.stack.getLast().rotate(radian, x, y, z);
	}

	public void rotateX(float radian, float x) {
		this.stack.getLast().rotateX(radian, x);
	}

	public void rotateY(float radian, float y) {
		this.stack.getLast().rotateY(radian, y);
	}

	public void rotateZ(float radian, float z) {
		this.stack.getLast().rotateZ(radian, z);
	}

}
